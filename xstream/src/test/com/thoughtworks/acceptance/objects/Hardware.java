/*
 * Copyright (C) 2003, 2004 Joe Walnes.
 * Copyright (C) 2006, 2007, 2018 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 *
 * Created on 26. September 2003 by Joe Walnes
 */
package com.thoughtworks.acceptance.objects;

public class Hardware extends StandardObject {
    private static final long serialVersionUID = 200310L;
    public String arch;
    public String name;

    public Hardware() {
    }

    public Hardware(final String arch, final String name) {
        this.arch = arch;
        this.name = name;
    }

}
