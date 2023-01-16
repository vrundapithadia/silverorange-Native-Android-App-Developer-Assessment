package com.silverorange.videoplayer.model

import com.google.gson.annotations.SerializedName

data class WireframeResponseModel(

	@field:SerializedName("WireframeResponseModel")
	val wireframeResponseModel: List<WireframeResponseModelItem?>? = null
)

data class Author(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class WireframeResponseModelItem(

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("fullURL")
	val fullURL: String? = null,

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("hlsURL")
	val hlsURL: String? = null
)
