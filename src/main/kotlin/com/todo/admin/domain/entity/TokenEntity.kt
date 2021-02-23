package com.todo.admin.domain.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedTimestamp
import java.util.*

/**
 * Token 管理テーブル
 */
@DynamoDBTable(tableName = "Token")
data class TokenEntity(
    @get: DynamoDBHashKey(attributeName = "user_id")
    @get: DynamoDBIndexRangeKey(
        globalSecondaryIndexNames = ["idx_token"]
    )
    var userId: String? = null,

    @get: DynamoDBIndexHashKey(
        attributeName = "token",
        globalSecondaryIndexNames = ["idx_token"]
    )
    var token: String = "",

    @get: DynamoDBTypeConvertedTimestamp(timeZone = "JST")
    @get: DynamoDBAttribute(attributeName = "expired_at")
    var expiredAt: Date? = null,

    @get: DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
    @get: DynamoDBTypeConvertedTimestamp(timeZone = "JST")
    @get: DynamoDBAttribute(attributeName = "created_at")
    var createdAt: Date? = null,

    @get: DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.ALWAYS)
    @get: DynamoDBTypeConvertedTimestamp(timeZone = "JST")
    @get: DynamoDBAttribute(attributeName = "updated_at")
    var updatedAt: Date? = null
)
