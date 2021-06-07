package com.developers.server.exception

class CommunityException(val errorCode: ErrorCode) : RuntimeException(errorCode.description) {
}