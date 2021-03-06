package io.fundrequest.core.request.claim.dto;

import io.fundrequest.core.infrastructure.mapping.BaseMapper;
import io.fundrequest.core.infrastructure.mapping.DefaultMappingConfig;
import io.fundrequest.core.request.claim.domain.Claim;
import io.fundrequest.core.request.mapper.BlockchainEventDtoMapper;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMappingConfig.class,
        uses = BlockchainEventDtoMapper.class)
public interface ClaimDtoMapper extends BaseMapper<Claim, ClaimDto> {
}