package com.newMedia.dto;

import com.newMedia.entity.MessageBoard;

import java.util.List;

public class ProductDetail {
    RProduct rProduct;
    List<MessageBoard> messageBoards;

    public ProductDetail(RProduct rProduct, List<MessageBoard> messageBoards) {
        this.rProduct = rProduct;
        this.messageBoards = messageBoards;
    }

    public RProduct getrProduct() {
        return rProduct;
    }

    public void setrProduct(RProduct rProduct) {
        this.rProduct = rProduct;
    }

    public List<MessageBoard> getMessageBoards() {
        return messageBoards;
    }

    public void setMessageBoards(List<MessageBoard> messageBoards) {
        this.messageBoards = messageBoards;
    }
}
