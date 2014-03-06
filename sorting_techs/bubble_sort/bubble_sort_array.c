/* Bubble Sort Array */

#include <stdio.h>
#include <stdlib.h>

void bubble_sort(int array[], int array_size);
void swap(int* x, int* y);
void print(int array[], int array_size);

void main(int argc, char* argv[]){
	if(argc < 2){
		printf("You have to enter array size \n");
		exit(0);
	}

	int array_size = atoi(argv[1]);
	int array[array_size];

	int i = 0;
	for(i;i<array_size;i++){
		array[i] = rand()%array_size;
	}
	printf("Unsorted array is: \n");
	print(array, array_size);
	bubble_sort(array, array_size);
	printf("Sorted array is: \n");
	print(array, array_size);
}

void bubble_sort(int array[], int array_size){
	int i = 0;
	
	for(i=array_size-1 ; i>0; i--){
		int j = 0;
		for(j;j<i;j++){
			if(array[j] >= array[j+1]){
				swap(&array[j], &array[j+1]);
			}
		}
	}
}

void swap(int* x, int* y){
	int temp = *x;
	*x = *y;
	*y = temp;
}

void print(int array[], int array_size){
	int i = 0;
	for(i; i < array_size; i++){
		printf(" %d ",array[i]);
	}
	printf(" \n");
}
