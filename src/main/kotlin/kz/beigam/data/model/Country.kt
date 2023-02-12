package kz.beigam.data.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Country(

    @BsonId
    val id: ObjectId = ObjectId(),
    val code: String,
    val flag: String,

)