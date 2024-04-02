open class Item(val name: String, val price: Double)

class Food(name: String, price: Double, val weight: String) : Item(name, price)
class Cloth(name: String, price: Double, val type: String) : Item(name, price)

class ShoppingList {
    private val itemList = mutableListOf<Item>()

    fun addItem() {

        println("Enter the item type you want to add (1 for Food, 2 for Cloth): ")
        val type = readLine()?.toIntOrNull() ?: 0
        when (type) {
            1 -> {
                print("Enter the item name you want to add: ")
                val name = readLine() ?: ""
                print("Enter the item price you want to add: ")
                var price = readLine()?.toDoubleOrNull() ?: 0.0
                while (price <= 0) {
                    println("Please enter a valid price!")
                    price = readLine()?.toDoubleOrNull() ?: 0.0
                }
                print("Enter the food weight: ")
                val weight = readLine() ?: ""

                itemList.add(Food(name, price, weight))
                println("$name is added successfully!")
            }
            2 -> {
                print("Enter the item name you want to add: ")
                val name = readLine() ?: ""
                print("Enter the item price you want to add: ")
                var price = readLine()?.toDoubleOrNull() ?: 0.0
                while (price <= 0) {
                    println("Please enter a valid price!")
                    price = readLine()?.toDoubleOrNull() ?: 0.0
                }
                print("Enter the cloth type: ")
                val clothType = readLine() ?: ""

                itemList.add(Cloth(name, price, clothType))
                println("$name is added successfully!")
            }
            else -> println("Invalid number. Please enter 1 for Food or 2 for Cloth.")

        }

    }



    fun displayItems() {
        println("Your shopping list:")
        itemList.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name} ${item.price}$ ${if (item is Food) (item as Food).weight else (item as Cloth).type}")
        }
    }

    fun deleteItem() {
        println("Enter the item number you want to delete: ")
        val itemNumber = readLine()?.toIntOrNull()?.let { it - 1 } ?: -1

        if (itemNumber in itemList.indices) {
            val deletedItem = itemList.removeAt(itemNumber)
            println("${deletedItem.name} is deleted successfully!")
        } else {
            println("Invalid item number.")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()

    var choice: Int
    do {

        println("\nMake your choice (1-2-3-4)")
        println("1. Add Item")
        println("2. Display Item")
        println("3. Delete Item")
        println("4. Exit")
        print("Your choice is: ")
        choice = readLine()?.toIntOrNull() ?: 4

        when (choice) {
            1 -> shoppingList.addItem()
            2 -> shoppingList.displayItems()
            3 -> shoppingList.deleteItem()
            4 -> println("Exiting...")
            else -> println("Invalid choice! Please try again.")
        }

    } while(choice!=4)
}