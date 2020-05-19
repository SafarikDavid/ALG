package Utils;

/**
 *
 * @author David
 */
public interface OrdersInterface {
    
    /**
     * Načte data ze souboru.
     * @param path cesta k souboru
     */
    public void loadData(String path);
    
    /**
     * Uloží všechna data do souboru.
     * @param path cesta k souboru
     */
    public void saveData(String path);
    
    /**
     * Vydá údaje o všech objednávkách.
     * @return naformátovaný výstup
     */
    public String getAllData();
    
}
