package com.example.todo_app_clean_architecture.mapper

import com.example.domain.model.DomainModel
import com.example.todo_app_clean_architecture.model.ItemModel

/**
 * Created by Nguyen Văn Lieu on 3/25/2020
 */

interface ItemMapper<DM:DomainModel,IM:ItemModel>{
    fun mapToItem(domainModel: DM):IM
    fun mapToDomain(itemModel:IM):DM
}