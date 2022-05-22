public class Food
{
    private String foodItem;
    private double foodPrice;
    private int ID;

    public Food(int ID, String foodItem, double foodPrice)
    {
        this.foodItem = foodItem;
        this.foodPrice = foodPrice;
        this.ID = ID;
    }

    public void placeOrder(String order){
        foodItem += order;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFormattedFood(){
        return ID + "," + foodItem + "," + foodPrice;
    }

    @Override
    public String toString()
    {
        return "ID: " + ID + "\n" + "Mad vare: " + foodItem + "\n" +
                "Pris: DKK " + foodPrice + "\n" + "-----------------" + "\n";
    }
}
