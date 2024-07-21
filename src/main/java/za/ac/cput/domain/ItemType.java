package za.ac.cput.domain;

import jakarta.persistence.*;
<<<<<<< HEAD
import java.util.Objects;
import java.util.Set;
=======

import java.util.Objects;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b

@Entity
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemTypeId;

    private String itemName;

    private String category;

    private int cost;
<<<<<<< HEAD
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Supplier> supplierName;
    @OneToMany(mappedBy = "itemTypes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Inventory> inventory;

=======

    private String supplierName;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b

    protected ItemType() {}

    private ItemType(Builder builder) {

        this.itemTypeId = builder.itemTypeId;
        this.itemName = builder.itemName;
        this.category = builder.category;
        this.cost = builder.cost;
        this.supplierName = builder.supplierName;
<<<<<<< HEAD
=======
        this.inventory = builder.inventory;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    }

    public long getItemTypeId() {
        return itemTypeId;
    }

    public String getItemName() {return itemName;}

    public String getCategory() {
        return category;
    }


    public int getCost() {
        return cost;
    }

<<<<<<< HEAD
    public Set<Supplier> getSupplierName() {
        return supplierName;
    }

=======

    public String getSupplierName() {
        return supplierName;
    }

    public Inventory getInventory() { return inventory;}

>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;
<<<<<<< HEAD
        return getItemTypeId() == itemType.getItemTypeId() && getCost() == itemType.getCost() && Objects.equals(getItemName(), itemType.getItemName()) && Objects.equals(getCategory(), itemType.getCategory()) && Objects.equals(getSupplierName(), itemType.getSupplierName()) && Objects.equals(inventory, itemType.inventory);
=======
        return itemTypeId == itemType.itemTypeId && cost == itemType.cost && Objects.equals(itemName, itemType.itemName) && Objects.equals(category, itemType.category) && Objects.equals(supplierName, itemType.supplierName) && Objects.equals(inventory, itemType.inventory);
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(getItemTypeId(), getItemName(), getCategory(), getCost(), getSupplierName(), inventory);
=======
        return Objects.hash(itemTypeId, itemName, category, cost, supplierName, inventory);
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "itemTypeId=" + itemTypeId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", supplierName='" + supplierName + '\'' +
<<<<<<< HEAD
=======
                ", inventory=" + inventory +
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
                '}';
    }

    public static class Builder {

        private long itemTypeId;
        private String itemName;
        private String category;
        private int cost;
<<<<<<< HEAD
        private Set<Supplier> supplierName;

=======
        private String supplierName;
        private Inventory inventory;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b

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

<<<<<<< HEAD
        public Builder setSupplierName(Set<Supplier> supplierName) {
=======
        public Builder setSupplierName(String supplierName) {
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
            this.supplierName = supplierName;
            return this;
        }

<<<<<<< HEAD
=======
        public Builder setInventory(Inventory inventory) {
            this.inventory = inventory;
            return this;
        }

>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
        public Builder copy(ItemType itemType) {

            this.itemTypeId = itemType.itemTypeId;
            this.itemName = itemType.itemName;
            this.category = itemType.category;
            this.cost = itemType.cost;
            this.supplierName = itemType.supplierName;
<<<<<<< HEAD
=======
            this.inventory = itemType.inventory;
>>>>>>> e20e071a407c97e32634986b6d427f824a4cc17b
            return this;
        }

        public ItemType build() {
            return new ItemType(this);
        }
    }
}
