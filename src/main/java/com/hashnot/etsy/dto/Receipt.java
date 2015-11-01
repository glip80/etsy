package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class Receipt {
    /**
     * The receipt's numeric ID.
     */
    @JsonProperty("receipt_id")
    private long receiptId;

    /**
     * The numeric ID of the order this receipt is associated with.
     */
    @JsonProperty("order_id")
    private long orderId;

    /**
     * The numeric ID of the seller for this receipt.
     */
    @JsonProperty("seller_user_id")
    private long sellerUserId;

    /**
     * The numeric ID of the buyer for this receipt.
     */
    @JsonProperty("buyer_user_id")
    private long buyerUserId;

    /**
     * Creation time, in epoch seconds.
     */
    @JsonProperty("creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date creationTime;

    /**
     * Last modification time, in epoch seconds.
     */
    @JsonProperty("last_modified_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date lastModifiedTime;

    /**
     * The name portion of the buyer's address.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The first line of the buyer's address.
     */
    @JsonProperty("first_line")
    private String firstLine;

    /**
     * The second line of the buyer's address.
     */
    @JsonProperty("second_line")
    private String secondLine;

    /**
     * The city for the buyer's address.
     */
    @JsonProperty("city")
    private String city;

    /**
     * The state for the buyer's address.
     */
    @JsonProperty("state")
    private String state;

    /**
     * The zip code of the buyer's address.
     */
    @JsonProperty("zip")
    private String zip;

    /**
     * The numeric ID of the buyer's country.
     */
    @JsonProperty("country_id")
    private int countryId;

    /**
     * The payment method used. May be pp, cc, ck, mo, or other (stands for paypal, credit card, check, money order, other).
     */
    @JsonProperty("payment_method")
    private String paymentMethod;

    /**
     * The email address where payment confirmation is sent.
     */
    @JsonProperty("payment_email")
    private String paymentEmail;

    /**
     * An optional message from the seller.
     */
    @JsonProperty("message_from_seller")
    private String messageFromSeller;

    /**
     * An optional message from the buyer.
     */
    @JsonProperty("message_from_buyer")
    private String messageFromBuyer;

    /**
     * True if the receipt was paid.
     */
    @JsonProperty("was_paid")
    private boolean paid;

    /**
     * The total sales tax of the receipt.
     */
    @JsonProperty("total_tax_cost")
    private BigDecimal totalTaxCost;

    /**
     * The total VAT of the receipt.
     */
    @JsonProperty("total_vat_cost")
    private BigDecimal totalVatCost;

    /**
     * Sum of the individual listings' (price * quantity). Does not included tax or shipping costs.
     */
    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    /**
     * The total shipping cost of the receipt.
     */
    @JsonProperty("total_shipping_cost")
    private BigDecimal totalShippingCost;

    /**
     * The ISO code (alphabetic) for the seller's native currency.
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * The machine generated acknowledgement from the payment system.
     */
    @JsonProperty("message_from_payment")
    private String messageFromPayment;

    /**
     * True if the items in the receipt were shipped.
     */
    @JsonProperty("was_shipped")
    private boolean shipped;

    /**
     * The email address of the buyer.
     */
    @JsonProperty("buyer_email")
    private String buyerEmail;

    /**
     * The email address of the seller.
     */
    @JsonProperty("seller_email")
    private String sellerEmail;

    /**
     * The total discount for the receipt, if using a discount (percent or fixed) Coupon. Free shipping Coupons are not reflected here; check the Coupon object for these.
     */
    @JsonProperty("discount_amt")
    private BigDecimal discountAmount;

    /**
     * total_price minus coupon discounts. Does not included tax or shipping costs.
     */
    @JsonProperty("subtotal")
    private BigDecimal subtotal;

    /**
     * total_price minus coupon discount plus tax and shipping costs.
     */
    @JsonProperty("grandtotal")
    private BigDecimal grandTotal;

    /**
     * grandtotal after payment adjustments.
     */
    @JsonProperty("adjusted_grandtotal")
    private BigDecimal adjustedGrandTotal;

    /**The tracking code for the shipment.
    DEPRECATED: This field will be removed by 10/2013. Use shipments instead. When a receipt has more than one shipment, behavior of this field is unspecified. */
    @JsonProperty("shipping_tracking_code")
    private String shipping_tracking_code;

    /**The tracking URL for the shipment.
    DEPRECATED: This field will be removed by 10/2013. Use shipments instead. When a receipt has more than one shipment, behavior of this field is unspecified. */
    @JsonProperty("shipping_tracking_url")
    private String shipping_tracking_url;

    /**The shipping carrier.
    DEPRECATED: This field will be removed by 10/2013. Use shipments instead. When a receipt has more than one shipment, behavior of this field is unspecified. */
    @JsonProperty("shipping_carrier")
    private String shipping_carrier;

    /**The shipping notification note text.
    DEPRECATED: This field will be removed by 10/2013. Use shipments instead. When a receipt has more than one shipment, behavior of this field is unspecified. */
    @JsonProperty("shipping_note")
    private String shipping_note;

    /**The date the last shipping notification was sent.
    DEPRECATED: This field will be removed by 10/2013. Use shipments instead. When a receipt has more than one shipment, behavior of this field is unspecified. */
    @JsonProperty("shipping_notification_date")
    private int shipping_notification_date;

    /**Shipment information associated to this receipt. */
/*
    @JsonProperty("shipments")
    private array(ReceiptShipment)shipments;
*/


    //Coupon 	private 	transactions_r 	Coupon 	The coupon for the receipt.
    //Country 	private 	transactions_r 	Country 	The country to which the order was shipped.
    /**
     * The buyer of the items in this receipt.
     */
    @JsonProperty("Buyer")
    private User buyer;

    /**
     * The seller of the items in this receipt
     */
    @JsonProperty("Seller")
    private User seller;

    /**The transactions associated to this receipt*/
    @JsonProperty("Transactions")
    private List<Transaction>transactions;

    /**
     * The listings associated to this receipt
     */
    @JsonProperty("Listings")
    private List<Listing> listings;

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentEmail() {
        return paymentEmail;
    }

    public void setPaymentEmail(String paymentEmail) {
        this.paymentEmail = paymentEmail;
    }

    public String getMessageFromSeller() {
        return messageFromSeller;
    }

    public void setMessageFromSeller(String messageFromSeller) {
        this.messageFromSeller = messageFromSeller;
    }

    public String getMessageFromBuyer() {
        return messageFromBuyer;
    }

    public void setMessageFromBuyer(String messageFromBuyer) {
        this.messageFromBuyer = messageFromBuyer;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public BigDecimal getTotalTaxCost() {
        return totalTaxCost;
    }

    public void setTotalTaxCost(BigDecimal totalTaxCost) {
        this.totalTaxCost = totalTaxCost;
    }

    public BigDecimal getTotalVatCost() {
        return totalVatCost;
    }

    public void setTotalVatCost(BigDecimal totalVatCost) {
        this.totalVatCost = totalVatCost;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalShippingCost() {
        return totalShippingCost;
    }

    public void setTotalShippingCost(BigDecimal totalShippingCost) {
        this.totalShippingCost = totalShippingCost;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getMessageFromPayment() {
        return messageFromPayment;
    }

    public void setMessageFromPayment(String messageFromPayment) {
        this.messageFromPayment = messageFromPayment;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public BigDecimal getAdjustedGrandTotal() {
        return adjustedGrandTotal;
    }

    public void setAdjustedGrandTotal(BigDecimal adjustedGrandTotal) {
        this.adjustedGrandTotal = adjustedGrandTotal;
    }

    public String getShipping_tracking_code() {
        return shipping_tracking_code;
    }

    public void setShipping_tracking_code(String shipping_tracking_code) {
        this.shipping_tracking_code = shipping_tracking_code;
    }

    public String getShipping_tracking_url() {
        return shipping_tracking_url;
    }

    public void setShipping_tracking_url(String shipping_tracking_url) {
        this.shipping_tracking_url = shipping_tracking_url;
    }

    public String getShipping_carrier() {
        return shipping_carrier;
    }

    public void setShipping_carrier(String shipping_carrier) {
        this.shipping_carrier = shipping_carrier;
    }

    public String getShipping_note() {
        return shipping_note;
    }

    public void setShipping_note(String shipping_note) {
        this.shipping_note = shipping_note;
    }

    public int getShipping_notification_date() {
        return shipping_notification_date;
    }

    public void setShipping_notification_date(int shipping_notification_date) {
        this.shipping_notification_date = shipping_notification_date;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", orderId=" + orderId +
                ", sellerUserId=" + sellerUserId +
                ", buyerUserId=" + buyerUserId +
                ", creationTime=" + creationTime +
                ", lastModifiedTime=" + lastModifiedTime +
                ", name='" + name + '\'' +
                ", firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", countryId=" + countryId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentEmail='" + paymentEmail + '\'' +
                ", messageFromSeller='" + messageFromSeller + '\'' +
                ", messageFromBuyer='" + messageFromBuyer + '\'' +
                ", paid=" + paid +
                ", totalTaxCost=" + totalTaxCost +
                ", totalVatCost=" + totalVatCost +
                ", totalPrice=" + totalPrice +
                ", totalShippingCost=" + totalShippingCost +
                ", currencyCode='" + currencyCode + '\'' +
                ", messageFromPayment='" + messageFromPayment + '\'' +
                ", shipped=" + shipped +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", discountAmount=" + discountAmount +
                ", subtotal=" + subtotal +
                ", grandTotal=" + grandTotal +
                ", adjustedGrandTotal=" + adjustedGrandTotal +
                ", shipping_tracking_code='" + shipping_tracking_code + '\'' +
                ", shipping_tracking_url='" + shipping_tracking_url + '\'' +
                ", shipping_carrier='" + shipping_carrier + '\'' +
                ", shipping_note='" + shipping_note + '\'' +
                ", shipping_notification_date=" + shipping_notification_date +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", transactions=" + transactions +
                ", listings=" + listings +
                '}';
    }
}
