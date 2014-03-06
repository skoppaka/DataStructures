/*Insertion Sort Array*/

#include <stdio.h>
#include <stdlib.h>

void insertion_sort(int array[], int array_size);
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
	insertion_sort(array, array_size);
	printf("Sorted array is: \n");
	print(array, array_size);
}

void insertion_sort(int array[], int array_size){
	int i = 0;
	
	for(i = 1; i< array_size; i++){
		int j = i;
		for(j;j>0;j--){
			if(array[j] >= array[j-1]){
				break;
			}
			else{	
				swap(&array[j], &array[j-1]);
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
