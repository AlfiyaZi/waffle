/**
 * Waffle (https://github.com/dblock/waffle)
 *
 * Copyright (c) 2010 - 2015 Application Security, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Application Security, Inc.
 */
package waffle.apache.catalina;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Simple Request Dispatcher.
 * 
 * @author dblock[at]dblock[dot]org
 */
public abstract class SimpleRequestDispatcher implements RequestDispatcher {

    /** The url. */
    private String url;

    /*
     * (non-Javadoc)
     * @see javax.servlet.RequestDispatcher#forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    public void forward(final ServletRequest request, final ServletResponse response) throws ServletException,
            IOException {
        final HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(304);
        httpResponse.addHeader("Location", this.url);
    }

    /**
     * Sets the url.
     *
     * @param value
     *            the new url
     */
    public void setUrl(final String value) {
        this.url = value;
    }

}
