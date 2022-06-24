package aej.kotlin.day1.tugas2.model

data class BaseResponse<T>(
    val code: String,
    val message: String,
    val data: T?
)
