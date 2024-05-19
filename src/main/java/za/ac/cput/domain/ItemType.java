package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemTypeId;


    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private String supplierName;

    protected ItemType() {}

    private ItemType(Builder builder) {

        this.itemTypeId = builder.itemTypeId;
        this.itemName = builder.itemName;
        this.category = builder.category;
        this.cost = builder.cost;
        this.supplierName = builder.supplierName;
    }

    public long getItemTypeId() {
        return itemTypeId;
    }

    public String getItemName() {

        return itemName;
    }

    public String getCategory() {
        return category;
    }


    public int getCost() {
        return cost;
    }


    public String getSupplierName() {
        return supplierName;
    }


    public Inventory getInventory() {
        return inventory;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;

        return itemTypeId == itemType.itemTypeId && cost == itemType.cost &&
                Objects.equals(itemName, itemType.itemName) &&
                Objects.equals(category, itemType.category) &&
                Objects.equals(supplierName, itemType.supplierName);

    }

    @Override
    public int hashCode() {

        return Objects.hash(itemTypeId, itemName, category, cost, supplierName);

    }

    @Override
    public String toString() {
        return "ItemType{" +

                "itemTypeId='" + itemTypeId + '\'' +

                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }


    public static class Builder {

    public static class Builder{

        private long itemTypeId;
        private String itemName;
        private String category;
        private int cost;
        private String supplierName;


        public Builder setItemTypeId(long itemTypeId) {
            this.itemTypeId = itemTypeId;
            return this;
        }

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setCost(int cost) {
            this.cost = cost;
            return this;
        }

        public Builder setSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder copy(ItemType itemType) {

            this.itemTypeId = itemType.itemTypeId;
            this.itemName = itemType.itemName;
            this.category = itemType.category;
            this.cost = itemType.cost;
            this.supplierName = itemType.supplierName;
            return this;
        }

        public ItemType build() {
            return new ItemType(this);
        }
    }
}
