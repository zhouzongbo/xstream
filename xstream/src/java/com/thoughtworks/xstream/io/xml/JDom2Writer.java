/*
 * Copyright (C) 2013, 2014, 2018 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 24. June 2013 by Joerg Schaible 
 */
package com.thoughtworks.xstream.io.xml;

import org.jdom2.DefaultJDOMFactory;
import org.jdom2.Element;
import org.jdom2.JDOMFactory;

import com.thoughtworks.xstream.io.naming.NameCoder;


/**
 * @since 1.4.5
 */
public class JDom2Writer extends AbstractDocumentWriter<Element, Element> {

    private final JDOMFactory documentFactory;

    /**
     * @since 1.4.5
     */
    public JDom2Writer(final Element container, final JDOMFactory factory, final NameCoder nameCoder) {
        super(container, nameCoder);
        documentFactory = factory;
    }

    /**
     * @since 1.4.5
     */
    public JDom2Writer(final Element container, final JDOMFactory factory) {
        this(container, factory, new XmlFriendlyNameCoder());
    }

    /**
     * @since 1.4.5
     */
    public JDom2Writer(final JDOMFactory factory, final NameCoder nameCoder) {
        this(null, factory, nameCoder);
    }

    /**
     * @since 1.4.5
     */
    public JDom2Writer(final JDOMFactory factory) {
        this(null, factory);
    }

    /**
     * @since 1.4.5
     */
    public JDom2Writer(final Element container, final NameCoder nameCoder) {
        this(container, new DefaultJDOMFactory(), nameCoder);
    }

    /**
     * @since 1.4.5
     */
    public JDom2Writer(final Element container) {
        this(container, new DefaultJDOMFactory());
    }

    /**
     * @since 1.4.5
     */
    public JDom2Writer() {
        this(new DefaultJDOMFactory());
    }

    @Override
    protected Element createNode(final String name) {
        final Element element = documentFactory.element(encodeNode(name));
        final Element parent = top();
        if (parent != null) {
            parent.addContent(element);
        }
        return element;
    }

    @Override
    public void setValue(final String text) {
        top().addContent(documentFactory.text(text));
    }

    @Override
    public void addAttribute(final String key, final String value) {
        top().setAttribute(documentFactory.attribute(encodeAttribute(key), value));
    }

    /**
     * @since 1.4.5
     */
    private Element top() {
        return getCurrent();
    }
}
