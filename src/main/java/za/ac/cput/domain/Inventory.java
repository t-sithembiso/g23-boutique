package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventoryId;
    private int quantity;

    @OneToMany(mappedBy = "itemType", cascade = CascadeType.ALL)
    private List<ItemType> itemType;

    protected Inventory() {
    }

    public Inventory(Builder builder){
        this.inventoryId = builder.inventoryId;
        this.quantity = builder.quantity;
        this.itemType = builder.itemType;
    }
    public long getInventoryId() {
        return inventoryId;
    }


    public int getQuantity() {
        return quantity;
    }

    public List<ItemType> getItemType() {
        return itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryId == inventory.inventoryId && quantity == inventory.quantity && Objects.equals(itemType, inventory.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, quantity, itemType);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", quantity=" + quantity +
                ", itemType=" + itemType +
                '}';
    }

    public static class Builder{
        private long inventoryId;
        private int quantity;
        private List<ItemType> itemType;

        public Builder setInventoryId(long inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setItemType(List<ItemType> itemType) {
            this.itemType = itemType;
            return this;
        }

        public Builder copy(Inventory inventory){
            this.inventoryId =inventory.inventoryId;
            this.quantity=inventory.quantity;
            this.itemType=inventory.itemType;
            return this;
        }
        public Inventory build(){return new Inventory(this);}
    }
}
