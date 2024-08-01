/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.bigtop.manager.server.model.converter;

import org.apache.bigtop.manager.dao.po.HostComponentPO;
import org.apache.bigtop.manager.server.config.MapStructSharedConfig;
import org.apache.bigtop.manager.server.model.vo.HostComponentVO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(config = MapStructSharedConfig.class)
public interface HostComponentConverter {

    HostComponentConverter INSTANCE = Mappers.getMapper(HostComponentConverter.class);

    @Mapping(target = "componentName", source = "componentPO.componentName")
    @Mapping(target = "displayName", source = "componentPO.displayName")
    @Mapping(target = "category", source = "componentPO.category")
    @Mapping(target = "serviceName", source = "componentPO.servicePO.serviceName")
    @Mapping(target = "clusterName", source = "componentPO.clusterPO.clusterName")
    @Mapping(target = "hostname", source = "hostPO.hostname")
    HostComponentVO fromPO2VO(HostComponentPO hostComponentPO);

    List<HostComponentVO> fromPO2VO(List<HostComponentPO> hostComponentPOList);
}