package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;
    

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    private void incQuality() {
        if (this.quality < 50) this.quality += 1;
    }

    private void decQuality() {
        if (this.quality > 0) this.quality -= 1;
    }

    public void updateQuality() {
        sellIn -= 1;

        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                sellIn = 0;
                quality = 80;
                break;

            case "Aged Brie":
                this.incQuality();
                if (sellIn < 0) this.incQuality();
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                this.incQuality();
                if (sellIn < 11) this.incQuality();
                if (sellIn < 6) this.incQuality();
                if (sellIn < 0) quality = 0;
                break;

            case "Conjured Mana Cake":
                this.decQuality();
                this.decQuality();
                if(sellIn < 0) {
                    this.decQuality();
                    this.decQuality();
                }
                break;

            default :
                this.decQuality();
                if (sellIn < 0) this.decQuality();

        }
    }

     

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
