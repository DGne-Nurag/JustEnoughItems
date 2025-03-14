package mezz.jei.gui.startup;

import mezz.jei.common.platform.Services;
import mezz.jei.gui.config.BookmarkJsonConfig;
import mezz.jei.gui.config.IBookmarkConfig;
import mezz.jei.gui.config.IngredientTypeSortingConfig;
import mezz.jei.gui.config.ModNameSortingConfig;

import java.nio.file.Path;

public record GuiConfigData(
	IBookmarkConfig bookmarkConfig,
	ModNameSortingConfig modNameSortingConfig,
	IngredientTypeSortingConfig ingredientTypeSortingConfig
) {
	public static GuiConfigData create() {
		Path configDir = Services.PLATFORM.getConfigHelper().createJeiConfigDir();

		IBookmarkConfig bookmarkConfig = new BookmarkJsonConfig(configDir);
		ModNameSortingConfig ingredientModNameSortingConfig = new ModNameSortingConfig(configDir.resolve("ingredient-list-mod-sort-order.ini"));
		IngredientTypeSortingConfig ingredientTypeSortingConfig = new IngredientTypeSortingConfig(configDir.resolve("ingredient-list-type-sort-order.ini"));

		return new GuiConfigData(
			bookmarkConfig,
			ingredientModNameSortingConfig,
			ingredientTypeSortingConfig
		);
	}
}
