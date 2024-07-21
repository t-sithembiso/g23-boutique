package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b

@Entity
public class Inventory {
    @Id
<<<<<<< HEAD
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    private long inventoryId;

    private int quantity;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "itemTypes_id")
    private ItemType itemTypes;
=======
    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    private List<ItemType> itemTypes;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b

    protected Inventory() {}

    private Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.quantity = builder.quantity;
        this.itemTypes = builder.itemTypes;
    }


<<<<<<< HEAD
    public Long getInventoryId() {
=======
    public long getInventoryId() {
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
        return inventoryId;
    }


    public int getQuantity() {
        return quantity;
    }


<<<<<<< HEAD
    public ItemType getItemTypes() {
        return itemTypes;

    }
=======
    public List<ItemType> getItemTypes() {
        return itemTypes;

    }

>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
<<<<<<< HEAD
        return inventoryId == inventory.inventoryId; // Assuming inventoryId is unique and sufficient for equality
=======

        return inventoryId == inventory.inventoryId && quantity == inventory.quantity &&
                Objects.equals(itemTypes, inventory.itemTypes);

>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(inventoryId);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Inventory inventory = (Inventory) o;
//        return inventoryId == inventory.inventoryId && quantity == inventory.quantity &&
//                Objects.equals(itemTypes, inventory.itemTypes);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(inventoryId, quantity, itemTypes);
//    }
=======

        return Objects.hash(inventoryId, quantity, itemTypes);

    }
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", quantity=" + quantity +
                ", itemTypes=" + itemTypes +
                '}';
    }

    public static class Builder {
        private long inventoryId;
        private int quantity;
<<<<<<< HEAD
        private ItemType itemTypes;
=======
        private List<ItemType> itemTypes;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b


        public Builder setInventoryId(long inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }


<<<<<<< HEAD
        public Builder setItemTypes(ItemType itemTypes) {
=======
        public Builder setItemTypes(List<ItemType> itemTypes) {
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
            this.itemTypes = itemTypes;
            return this;
        }

        public Builder copy(Inventory inventory) {
            this.inventoryId = inventory.inventoryId;
            this.quantity = inventory.quantity;
            this.itemTypes = inventory.itemTypes;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }

    }
}
