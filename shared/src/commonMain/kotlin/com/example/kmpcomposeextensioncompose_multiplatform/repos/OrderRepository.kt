package com.example.kmpcomposeextensioncompose_multiplatform.repos

import com.example.kmpcomposeextensioncompose_multiplatform.SharedRes
import com.example.kmpcomposeextensioncompose_multiplatform.models.OrderItemModel

interface OrderRepository {
    fun getMockOrderList(): List<OrderItemModel>
}

class OrderRepositoryImpl : OrderRepository {
    override fun getMockOrderList(): List<OrderItemModel> =
        List(5) { OrderItemModel(products = listOf(SharedRes.images.phone, SharedRes.images.teapot)) }
}

