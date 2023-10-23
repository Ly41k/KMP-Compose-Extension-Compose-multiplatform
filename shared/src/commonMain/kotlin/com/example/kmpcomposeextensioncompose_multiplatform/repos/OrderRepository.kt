package com.example.kmpcomposeextensioncompose_multiplatform.repos

import com.example.kmpcomposeextensioncompose_multiplatform.MainRes
import com.example.kmpcomposeextensioncompose_multiplatform.models.OrderItemModel

interface OrderRepository {
    fun getMockOrderList(): List<OrderItemModel>
}

class OrderRepositoryImpl : OrderRepository {
    override fun getMockOrderList(): List<OrderItemModel> {
        return List(5) {
            OrderItemModel(
                products = listOf(
                    MainRes.image.ic_phone,
                    MainRes.image.ic_teapot,
                )
            )
        }
    }
}

