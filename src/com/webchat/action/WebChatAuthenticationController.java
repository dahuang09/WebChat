// Copyright (c) 1998-2016 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2016-XX-XX, damon.huang, creation
// ============================================================================
package com.webchat.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author damon.huang
 *
 */
@Controller
@RequestMapping("/authentication")
public class WebChatAuthenticationController {

    Logger log = LoggerFactory.getLogger(WebChatAuthenticationController.class);

    /*@RequestMapping(value="/validate", method = RequestMethod.GET)
    public void validate(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test===============");
        final String signature = req.getParameter("signature");
        final String timestamp = req.getParameter("timestamp");
        final String nonce = req.getParameter("nonce");
        final String echostr = req.getParameter("echostr");
        final boolean isSuccess = AuthenticationUtil.validateSignature(signature , timestamp, nonce);
        final PrintWriter out = resp.getWriter();
        if (isSuccess) {
            out.print(echostr);
        }
    }*/

    @RequestMapping(value="/hello")
    public String HelloWorld() {
        log.debug("hello world");
        return "HelloWorld";
    }

}
