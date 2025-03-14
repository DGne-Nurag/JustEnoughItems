package mezz.jei.api.runtime;

import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.ingredients.ITypedIngredient;
import org.jetbrains.annotations.ApiStatus;

/**
 * The {@link IIngredientVisibility} allows mod plugins to do advanced filtering of
 * ingredients based on what is visible in JEI.
 *
 * An instance available from {@link IJeiHelpers#getIngredientVisibility()}.
 *
 * @since JEI 9.3.0
 */
@ApiStatus.NonExtendable
public interface IIngredientVisibility {
	/**
	 * Returns true if the given ingredient is visible in JEI's ingredient list.
	 *
	 * Returns false if the given ingredient is invalid, removed by the server,
	 * hidden by a mod, or hidden by the player.
	 *
	 * @since 9.3.0
	 */
	<V> boolean isIngredientVisible(IIngredientType<V> ingredientType, V ingredient);

	/**
	 * Returns true if the given ingredient is visible in JEI's ingredient list.
	 *
	 * Returns false if the given ingredient is invalid, removed by the server,
	 * hidden by a mod, or hidden by the player.
	 *
	 * @since 10.0.0
	 */
	<V> boolean isIngredientVisible(ITypedIngredient<V> typedIngredient);

	/**
	 * Register a listener that receives updates when ingredient visibility changes.
	 *
	 * @since 11.5.0
	 */
	void registerListener(IListener listener);

	/**
	 * A listener that receives updates when ingredients are made visible or invisible.
	 *
	 * @since 11.5.0
	 */
	interface IListener {
		/**
		 * Called when ingredients are made visible or invisible.
		 * @since 11.5.0
		 */
		<V> void onIngredientVisibilityChanged(ITypedIngredient<V> ingredient, boolean visible);
	}
}
