/*Quick Sort Array*/

#include <stdio.h>
#include <stdlib.h>

void quick_sort(int array[], int start, int end);
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
	quick_sort(array, 0, array_size-1);
	printf("Sorted array is: \n");
	print(array, array_size);
}

void quick_sort(int array[], int start, int end){

	if(start >= end){
		return;
	}
	int pivot = array[end];
	int pivotindex = start;
	int i = start;
	for(i;i< end;i++){
		if(array[i]<=pivot){
			swap(&array[i],&array[pivotindex]);
			pivotindex++;
		}
	}

	swap(&array[pivotindex],&array[end]);
		
	quick_sort(array, start,pivotindex-1);
	quick_sort(array, pivotindex+1 , end);
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
