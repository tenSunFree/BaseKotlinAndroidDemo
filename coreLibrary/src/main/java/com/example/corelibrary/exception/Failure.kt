package com.example.corelibrary.exception

sealed class Failure {
    object NetworkException : Failure()
    object ServerError : Failure()
    object LocalDataNotFound : Failure()
}