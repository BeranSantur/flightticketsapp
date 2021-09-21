package com.beransantur.flightticketsapp.utils.log;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@RequiredArgsConstructor
public class InfoLogMessage {

    private final String entityName;

    public void entityFoundById(Integer id) {
        log.info(" {} with given {} has been found", entityName, id);
    }

    public void allEntitiesFound() {
        log.info(" All {}'s has been found", entityName);
    }

    public void entityCreated() {
        log.info("{} has been created", entityName);
    }

    public void entityWasNotFound(){
        log.info("{} has not found", entityName);
    }
}
