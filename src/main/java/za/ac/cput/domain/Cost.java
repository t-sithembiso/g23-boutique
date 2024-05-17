package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;

public class Cost {

    private String costId;
    private String inventoryId;
    private String costDescription;
    private Double amount;
    private Date dateIncurred;


    public Cost() {
    }

    public Cost(Builder builder) {
        this.costId = builder.costId;
        this.inventoryId = builder.inventoryId;
        this.costDescription = builder.costDescription;
        this.amount = builder.amount;
        this.dateIncurred = builder.dateIncurred;
    }

    public String getCostId() {
        return costId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDateIncurred() {
        return dateIncurred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return Objects.equals(costId, cost.costId) && Objects.equals(inventoryId, cost.inventoryId) && Objects.equals(costDescription, cost.costDescription) && Objects.equals(amount, cost.amount) && Objects.equals(dateIncurred, cost.dateIncurred);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costId, inventoryId, costDescription, amount, dateIncurred);
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costId='" + costId + '\'' +
                ", inventoryId='" + inventoryId + '\'' +
                ", costDescription='" + costDescription + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }

    public static class Builder {
        private String costId;
        private String inventoryId;
        private String costDescription;
        private Double amount;
        private Date dateIncurred;

        public Builder setCostId(String costId) {
            this.costId = costId;
            return this;
        }

        public Builder setInventoryId(String inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder setCostDescription(String costDescription) {
            this.costDescription = costDescription;
            return this;
        }

        public Builder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDateIncurred(Date dateIncurred) {
            this.dateIncurred = dateIncurred;
            return this;
        }

        public Builder copy(Cost cost) {
            this.costId = cost.costId;
            this.inventoryId = cost.inventoryId;
            this.costDescription = cost.costDescription;
            this.amount = cost.amount;
            this.dateIncurred = cost.dateIncurred;
            return this;
        }
        public Cost build(){
                return new Cost(this);
        }
    }
}


