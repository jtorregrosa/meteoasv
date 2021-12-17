package com.jtorregrosa.meteoasv.mappers;

import com.jtorregrosa.meteoasv.aemet.envelopes.master.MunicipalityResponse;
import com.jtorregrosa.meteoasv.domain.Municipality;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Aemet municipality mapper.
 */
@Mapper(componentModel = "spring")
public interface AemetMunicipalityMapper {
    /**
     * To domain municipality.
     *
     * @param municipalityResponse the municipality response
     * @return the municipality
     */
    Municipality toDomain(MunicipalityResponse municipalityResponse);

    /**
     * To domain list.
     *
     * @param municipalityResponse the municipality response
     * @return the list
     */
    List<Municipality> toDomain(List<MunicipalityResponse> municipalityResponse);
}
