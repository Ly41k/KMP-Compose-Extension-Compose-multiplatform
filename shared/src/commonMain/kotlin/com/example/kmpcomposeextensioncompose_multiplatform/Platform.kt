package com.example.kmpcomposeextensioncompose_multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform