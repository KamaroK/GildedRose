package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  public static String vest = "+5 Dexterity Vest";
  public static String brie = "Aged Brie";
  public static String elixir = "Elixir of the Mongoose";
  public static String sulfuras = "Sulfuras, Hand of Ragnaros";
  public static String concert = "Backstage passes to a TAFKAL80ETC concert";
  public static String conjured = "Conjured Mana Cake";

  @Test
  @DisplayName("Test that values are changed correctly")
  void valueTest() {
    Item element = new Item("foo", 2, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
    assertThat(element.sellIn, is(1));
    assertThat(element.quality, is(19)); 

  }

  @Test
  @DisplayName("Test that quality don't exceed 50")
  void QualityTest() {
    Item element1 = new Item("Aged Brie", 2, 50);
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 48);

    GildedRose app = new GildedRose(new Item[] {element1, element2});
    app.updateQuality();
    assertThat(element1.quality, is(50));
    assertThat(element2.quality, is(50));
  }
  
  @Test
  @DisplayName("Test that Aged Brie is changed correctly")
  void agedBrieTest() {
    Item element1 = new Item("Aged Brie", 2, 0);
    Item element2 = new Item("Aged Brie", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element1, element2});
    app.updateQuality();
    assertThat(element1.sellIn, is(1));
    assertThat(element1.quality, is(1));
    assertThat(element2.sellIn, is(-1));
    assertThat(element2.quality, is(2));
  }

  @Test
  @DisplayName("Test that Sulfuras, Hand of Ragnaros is changed correctly")
  void sulfurasTest() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(0));
    assertThat(element.quality, is(80));
  }

  @Test
  @DisplayName("Test that Backstage passes to a TAFKAL80ETC concert is changed correctly")
  void backstageTest() {
    Item item1 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    Item item2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
    Item item3 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
    Item item4 = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
    Item item5 = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50);

    GildedRose app = new GildedRose(new Item[] {item1, item2, item3, item4});
    app.updateQuality();
    assertThat(item1.sellIn, is(14));
    assertThat(item1.quality, is(21));
    assertThat(item2.sellIn, is(9));
    assertThat(item2.quality, is(22));
    assertThat(item3.sellIn, is(4));
    assertThat(item3.quality, is(23));
    assertThat(item4.sellIn, is(-1));
    assertThat(item4.quality, is(0));
    assertThat(item5.quality, is(50));

  }

  @Test
  @DisplayName("Test that default element is changed correctly")
  void VestTest() {
    Item element1 = new Item(vest, 2, 50);
    Item element2 = new Item(vest, 0, 50);
    Item element3 = new Item(vest, -2, 6);

    GildedRose app = new GildedRose(new Item[] {element1, element2, element3});
    app.updateQuality();
    assertThat(element1.quality, is(49));
    assertThat(element2.quality, is(48));
    assertThat(element3.quality, is(4));
  }

}

