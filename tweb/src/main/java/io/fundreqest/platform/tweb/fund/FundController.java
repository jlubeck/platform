package io.fundreqest.platform.tweb.fund;

import io.fundreqest.platform.tweb.infrastructure.mav.AbstractController;
import io.fundrequest.core.request.RequestService;
import io.fundrequest.core.request.view.RequestDto;
import io.fundrequest.platform.faq.FAQService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FundController extends AbstractController {
    private static final String FAQ_FUND_GITHUB = "fundGithub";

    private final FAQService faqService;
    private final RequestService requestService;

    public FundController(final RequestService requestService, final FAQService faqService) {
        this.requestService = requestService;
        this.faqService = faqService;
    }

    @RequestMapping("/fund/{type}")
    public ModelAndView details(@PathVariable String type, @RequestParam(name = "url", required = false) String url) {
        return modelAndView()
                .withObject("url", url)
                .withObject("faqs", faqService.getFAQsForPage(FAQ_FUND_GITHUB))
                .withView("pages/fund/" + type)
                .build();
    }

    @RequestMapping("/requests/{request-id}/fund")
    public ModelAndView fundRequestById(@PathVariable("request-id") Long requestId) {
        final RequestDto request = requestService.findRequest(requestId);
        return modelAndView()
                .withObject("url", request.getIssueInformation().getUrl())
                .withObject("faqs", faqService.getFAQsForPage(FAQ_FUND_GITHUB))
                .withView("pages/fund/" + request.getIssueInformation().getPlatform().name().toLowerCase())
                .build();
    }
}
