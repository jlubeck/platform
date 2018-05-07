package io.fundreqest.platform.tweb.request.dto;

import io.fundrequest.core.infrastructure.mapping.BaseMapper;
import io.fundrequest.core.request.view.RequestDto;
import org.springframework.stereotype.Component;

@Component
public class RequestViewMapper implements BaseMapper<RequestDto, RequestView> {

    @Override
    public RequestView map(RequestDto r) {
        return RequestView
                .builder()
                .id(r.getId())
                .icon("https://github.com/" + r.getIssueInformation().getOwner() + ".png")
                .owner(r.getIssueInformation().getOwner())
                .repo(r.getIssueInformation().getRepo())
                .issueNumber(r.getIssueInformation().getNumber())
                .platform(r.getIssueInformation().getPlatform().name())
                .title(r.getIssueInformation().getTitle())
                .status(r.getStatus().name())
                .fase(r.getStatus().getFase().name())
                .starred(r.isLoggedInUserIsWatcher())
                .technologies(r.getTechnologies())
                .funds(r.getFunds())
                .build();
    }
}