

class GildedRoseRef {
    private Item[] items;

    public GildedRoseRef(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name){
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Aged Brie":
                    items[i] = updateAgedBrieItem(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i] = updateBackstageItem(items[i]);
                    break;
                case "Conjured":
                    items[i] = updateConjuredItem(items[i]);
                    break;
                default:
                    items[i] = updateNormalItem(items[i]);
            }
        }
    }

    private Item updateAgedBrieItem(Item agedBrie){
        agedBrie = updateAgedBrieQuality(agedBrie);
        agedBrie = updateDay(agedBrie);
        agedBrie = checkQualityBounds(agedBrie);
        return agedBrie;
    }

    private Item updateBackstageItem(Item backstage){
        backstage = updateBackstageQuality(backstage);
        backstage = updateDay(backstage);
        backstage = checkQualityBounds(backstage);
        return backstage;
    }

    private Item updateConjuredItem(Item conjured){
        conjured = updateConjuredQuality(conjured);
        conjured = updateDay(conjured);
        conjured = checkQualityBounds(conjured);
        return conjured;
    }

    private Item updateNormalItem(Item normal){
        normal = updateNormalQuality(normal);
        normal = updateDay(normal);
        normal = checkQualityBounds(normal);
        return normal;
    }


    private Item updateAgedBrieQuality(Item agedBrie){
        agedBrie.quality += 1;
        return agedBrie;
    }

    private Item updateBackstageQuality(Item backstage){
        if (backstage.sellIn <= 0) {
            backstage.quality = 0;
        } else if (backstage.sellIn <= 5) {
            backstage.quality = backstage.quality + 3;
        } else if (backstage.sellIn <= 10) {
            backstage.quality = backstage.quality + 2;
        }

        return backstage;
    }

    private Item updateConjuredQuality(Item conjured){
        if (conjured.sellIn <= 0) {
            conjured.quality -= 4;
        } else {
            conjured.quality -= 2;
        }

        return conjured;
    }

    private Item updateNormalQuality(Item normal){
        if (normal.sellIn <= 0) {
            normal.quality -= 2;
        } else {
            normal.quality -= 1;
        }

        return normal;
    }

    private Item checkQualityBounds(Item item){
        if (item.quality > 50) {
            item.quality = 50;
        }else if (item.quality < 0) {
            item.quality = 0;
        }

        return item;
    }


    private Item updateDay(Item item){
        item.sellIn -= 1;
        return item;
    }


    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }




}
