package com.doohong.shoesfit.kakao;
public class NutritionFacts{
    private final int servingSize; // 필수 매개변수
    private final int servings; // 필수 매개변수
    private final int calories; // 선택 매개변수
    private final int fat; // 선택 매개변수

    public static class Builder{
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val){
            calories = val; return this;
        }
        public Builder fat(int val){
            fat = val; return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder. calories;
        fat = builder.fat;
    }

    public static void main(String[] args) {
        NutritionFacts test = new NutritionFacts.Builder(3,0).build();
        NutritionFacts.Builder ab ;
    }
}