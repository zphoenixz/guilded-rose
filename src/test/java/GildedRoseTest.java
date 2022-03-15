import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    @Test
    public void shouldReduceQualityTwiceWhenSellInPasses() throws Exception{
        int expectedQuality = 8;
        Item[] testItems = {
                new Item("Item1", 0, 10),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldNotReduceQualityToNegative() throws Exception{
        int expectedQuality = 0;
        Item[] testItems = {
                new Item("Item2", 0, 1),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldIncreaseQualityIfAgedBrie() throws Exception{
        int expectedQuality = 2;
        int expectedSellIn = -1;

        Item[] testItems = {
                new Item("Aged Brie", 0, 0),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
        assertEquals(expectedSellIn, guildedRose.items[0].sellIn);
    }

    @Test
    public void shouldNotIncreaseQualityIfMoreThan50AgedBrie() throws Exception{
        int expectedQuality = 50;

        Item[] testItems = {
                new Item("Aged Brie", 10, 50),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldKeepQualityIfSulfuras() throws Exception{
        int expectedQuality = 80;
        Item[] testItems = {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldKeepSellInIfSulfuras() throws Exception{
        int expectedSellIn = 10;
        Item[] testItems = {
                new Item("Sulfuras, Hand of Ragnaros", 10, 3),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedSellIn, guildedRose.items[0].sellIn);
    }

    @Test
    public void shouldIncreaseQuality3IfBackstageAndSellInLessOrEqualThan5() throws Exception{
        int expectedQuality = 13;

        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldIncreaseQuality2IfBackstageAndSellInLessOrEqualThan10AndMoreThan5() throws Exception{
        int expectedQuality = 12;

        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldDecreaseQuality0IfBackstageAndSellIsEqual0() throws Exception{
        int expectedQuality = 0;

        Item[] testItems = {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldDecreaseBy2IfConjuredAndSellInMoreThan0() throws Exception{
        int expectedQuality = 0;

        Item[] testItems = {
                new Item("Conjured", 2, 2),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }

    @Test
    public void shouldDecreaseBy4IfConjuredAndSellIn0() throws Exception{
        int expectedQuality = 0;

        Item[] testItems = {
                new Item("Conjured", 0, 4),
        };
        GildedRose guildedRose = new GildedRose(testItems);
        guildedRose.updateQuality();
        assertEquals(expectedQuality, guildedRose.items[0].quality);
    }


}