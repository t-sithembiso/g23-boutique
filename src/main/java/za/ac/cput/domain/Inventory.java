package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Inventory {
    @Id
    private long inventoryId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "itemTypes_id")
    private ItemType itemTypes;

    protected Inventory() {}

    private Inventory(Builder builder) {
        this.inventoryId = builder.inventoryId;
        this.quantity = builder.quantity;
        this.itemTypes = builder.itemTypes;
    }


    public Long getInventoryId() {
        return inventoryId;
    }


    public int getQuantity() {
        return quantity;
    }


    public ItemType getItemTypes() {
        return itemTypes;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryId == inventory.inventoryId; // Assuming inventoryId is unique and sufficient for equality
    }

    @Override
    public int hashCode() {
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
        private ItemType itemTypes;


        public Builder setInventoryId(long inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }


        public Builder setItemTypes(ItemType itemTypes) {
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
