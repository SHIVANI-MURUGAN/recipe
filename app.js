angular.module('recipeApp', ['ngAnimate', 'recipeApp.directives'])
.controller('RecipeController', ['$scope', 'RecipeFactory', function($scope, RecipeFactory) {
    $scope.recipes = RecipeFactory.getRecipes();

    $scope.newRecipe = {};
    $scope.searchFilter = '';
    $scope.ingredientSearch = '';
    $scope.currentCategory = 'All'; // Initialize with 'All'

    $scope.addRecipe = function() {
        $scope.recipes.push({
            name: $scope.newRecipe.name,
            ingredients: $scope.newRecipe.ingredients,
            category: $scope.newRecipe.category
        });
        $scope.newRecipe = {};
    };

    $scope.deleteRecipe = function(recipe) {
        var index = $scope.recipes.indexOf(recipe);
        if (index > -1) {
            $scope.recipes.splice(index, 1);
        }
    };

    $scope.setCategory = function(category) {
        $scope.currentCategory = category;
    };

    $scope.categoryFilter = function(item) {
        if ($scope.currentCategory === 'All') {
            return true;
        } else {
            return item.category === $scope.currentCategory;
        }
    };
}]);

angular.module('recipeApp.directives', [])
.directive('recipeItem', function() {
    return {
        restrict: 'E',
        scope: {
            recipe: '='
        },
        template: '<div class="recipe-box"><div class="recipe-name">{{ recipe.name }}</div></div>'
    };
});

angular.module('recipeApp')
.factory('RecipeFactory', function() {
    var recipes = [
        { name: 'Tomato Soup', ingredients: 'Tomatoes, Onion, Garlic, Basil', category: 'Soups' },
        { name: 'Vegetable Soup', ingredients: 'Mixed Vegetables, Broth, Herbs', category: 'Soups' },
        {name: 'Mushroom Soup', ingredients: 'Mushrooms, Pepper, Herbs', category: 'Soups'},
        { name: 'Caesar Salad', ingredients: 'Lettuce, Croutons, Parmesan Cheese', category: 'Salads' },
        { name: 'Greek Salad', ingredients: 'Tomatoes, Cucumbers, Feta Cheese', category: 'Salads' },
        { name: 'Chocolate Cake', ingredients: 'Flour, Sugar, Cocoa, Eggs', category: 'Cakes' },
        { name: 'Vanilla Cupcakes', ingredients: 'Flour, Sugar, Butter, Vanilla Extract', category: 'Cakes' },
        {name: 'Muffins', ingredients: 'Flour, Sugar, Butter, Vanilla Extract', category: 'Cakes'},
        { name: 'Lemon Rice', ingredients: 'Rice, Lemon, Curry Leaves', category: 'Variety Rice' },
        { name: 'Tamarind Rice', ingredients: 'Rice, Tamarind, Peanuts, Spices', category: 'Variety Rice' }
        // Add more recipes and categories as needed
    ];

    return {
        getRecipes: function() {
            return recipes;
        }
    };
});
