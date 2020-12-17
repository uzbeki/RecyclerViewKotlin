/**
 * Practising lists in Kotlin*/

package com.example.affirmations

open class Item(val name: String, val price: Int) {
    override fun toString(): String {
        return name
    }
}

class Noodles : Item("Noodles", 10) {

}

class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        if (toppings.isEmpty()) {
            return "$name Chef's Choice"
        } else {
            return name + ": " + toppings.joinToString(" ")
        }
    }
}

class Order(val orderNumber: Int) {
    private val itemsList = mutableListOf<Item>()

    fun addItem(newItem: Item): Order {
        itemsList.add(newItem)
        return this
    }

    fun addAll(newItems: List<Item>): Order {
        itemsList.addAll(newItems)
        return this
    }

    fun print() {
        println("Order number #%s".format(orderNumber))
        var total = 0
        for (item in itemsList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $total")


    }
}


fun main() {
    val ordersList = mutableListOf<Order>()
    val order1 = Order(1)
    order1.addItem(Noodles())
    ordersList.add(order1)


    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())

    ordersList.add(order2)


    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    ordersList.add(order3)

    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
    ordersList.add(order4)

    ordersList.add(
        Order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach"))
    )

    for (order in ordersList) {
        order.print()
        println()
    }


}



