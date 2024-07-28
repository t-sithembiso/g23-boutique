package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemTypeId;

    private String itemName;

    private String category;

    private int cost;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Supplier> suppliers;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Inventory> inventory;

    protected ItemType() {}

    private ItemType(Builder builder) {
        this.itemTypeId = builder.itemTypeId;
        this.itemName = builder.itemName;
        this.category = builder.category;
        this.cost = builder.cost;
        this.suppliers = builder.suppliers;
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

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public Set<Inventory> getInventory() {
        return inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;
        return itemTypeId == itemType.itemTypeId &&
                cost == itemType.cost &&
                Objects.equals(itemName, itemType.itemName) &&
                Objects.equals(category, itemType.category) &&
                Objects.equals(suppliers, itemType.suppliers) &&
                Objects.equals(inventory, itemType.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemTypeId, itemName, category, cost, suppliers, inventory);
    }

    @Override
    public String toString() {
            return "ItemType{" +
                "itemTypeId=" + itemTypeId +
                ", itemName='" + itemName + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", suppliers=" + suppliers +
                ", inventory=" + inventory +
                '}';
    }

    public static class Builder {
        private long itemTypeId;
        private String itemName;
        private String category;
        private int cost;
        private Set<Supplier> suppliers;

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

        public Builder setSuppliers(Set<Supplier> suppliers) {
            this.suppliers = suppliers;
            return this;
        }

        public Builder copy(ItemType itemType) {
            this.itemTypeId = itemType.itemTypeId;
            this.itemName = itemType.itemName;
            this.category = itemType.category;
            this.cost = itemType.cost;
            this.suppliers = itemType.suppliers;
            return this;
        }

        public ItemType build() {
            return new ItemType(this);
        }
    }
}
