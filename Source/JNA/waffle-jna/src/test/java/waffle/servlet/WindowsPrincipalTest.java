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
package waffle.servlet;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import waffle.windows.auth.IWindowsAccount;
import waffle.windows.auth.IWindowsIdentity;

/**
 * The Class WindowsPrincipalTest.
 *
 * @author dblock[at]dblock[dot]org
 */
public class WindowsPrincipalTest {

    /** The Constant TEST_FQN. */
    private static final String TEST_FQN = "ACME\\john.smith";

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        final IWindowsIdentity windowsIdentity = Mockito.mock(IWindowsIdentity.class);
        Mockito.when(windowsIdentity.getFqn()).thenReturn(WindowsPrincipalTest.TEST_FQN);
        Mockito.when(windowsIdentity.getGroups()).thenReturn(new IWindowsAccount[0]);
        final WindowsPrincipal principal = new WindowsPrincipal(windowsIdentity);
        Assert.assertEquals(WindowsPrincipalTest.TEST_FQN, principal.getName());
        Assert.assertEquals(WindowsPrincipalTest.TEST_FQN, principal.toString());
    }

}
