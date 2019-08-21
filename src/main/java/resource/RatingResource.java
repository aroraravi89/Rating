package resource;

import domain.Details;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RatingResource {

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public ResponseEntity<List<Details>> listAllUsers() {
        List<Details> details = getUserDetails();
        if (details.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Details>>(details, HttpStatus.OK);
    }

    private List<Details> getUserDetails() {
        ArrayList<String> Category = new ArrayList<String>();
        ArrayList<String> Item = new ArrayList<String>();
        ArrayList<Integer> Price = new ArrayList<Integer>();
        ArrayList<Integer> Shipping = new ArrayList<Integer>();
        ArrayList<Integer> Rating = new ArrayList<Integer>();
        insertData(Category, Item, Price, Shipping, Rating);
        try {
            return getRatingDetails(Category, Item, Price, Shipping, Rating);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    private List<Details> getRatingDetails(ArrayList<String> Category, ArrayList<String> Item, ArrayList<Integer> Price, ArrayList<Integer> Shipping, ArrayList<Integer> Rating) {
        Integer TotalRating = 0;
        Integer TotalPrice = 0;
        List<Details> finalList = new ArrayList<>();
        Set<String> checkSet = new HashSet<>();
        for (int i = 0; i < 20;) {
            int selectedCategory = (int) (Math.random() * 20);
            int selectedItem = (int) (Math.random() * 10);
            int selectedPrice = (int) (Math.random() * 20);
            int selectedShipping = (int) (Math.random() * 4);
            int selectedRating = (int) (Math.random() * 5);
            if (!checkSet.contains(Category.get(selectedCategory))) {
                checkSet.add(Category.get(selectedCategory));
                int TotalCost = Shipping.get(selectedShipping) + Price.get(selectedPrice);
                if (TotalCost <= 50) {
                    i += 1;
                    Details obj;
                    obj = new Details(Category.get(selectedCategory), Item.get(selectedItem), TotalCost, Rating.get(selectedRating));
                    TotalPrice += TotalCost;
                    TotalRating += Rating.get(selectedRating);
                    System.out.println(Category.get(selectedCategory) + ":" + Item.get(selectedItem)
                            + ":TotalCost  " + TotalCost + ":Rating  " + Rating.get(selectedRating) + ""
                    );
                    finalList.add(obj);
                }
            }
        }
        Details obj = new Details();
        obj.setTotalPrice(TotalPrice);
        obj.setRating(TotalRating);
        finalList.add(obj);
        System.out.println("Total Price=" + TotalPrice + "\n" + "Total Rating=" + TotalRating);
        return finalList;
    }

    private void insertData(ArrayList<String> Category, ArrayList<String> Item, ArrayList<Integer> Price, ArrayList<Integer> Shipping, ArrayList<Integer> Rating) {
        for (int i = 0; i < 20; i++) {
            Category.add("Category" + i);
        }
        for (int i = 0; i < 10; i++) {
            Item.add("Item" + i);
        }

        for (int i = 1; i <= 20; i++) {
            Price.add(i);
        }

        for (int i = 2; i <= 5; i++) {
            Shipping.add(i);
        }

        for (int i = 1; i <= 5; i++) {
            Rating.add(i);

        }

    }

}
