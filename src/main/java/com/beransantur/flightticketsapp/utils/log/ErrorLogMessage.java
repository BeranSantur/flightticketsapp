package com.beransantur.flightticketsapp.utils.log;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@RequiredArgsConstructor
public class ErrorLogMessage {

    private final String entityName;

    public void errorWhenGettingEntityById(Integer id) {
        log.error("Error when getting {} by id: {}", entityName, id);
    }

    public void errorWhenGettingAllEntities() {
        log.error("Error when getting all {}'s ", entityName);
    }

    public void errorWhenSavingNewEntity(){
        log.error("Error when saving {} ", entityName);
    }
}
