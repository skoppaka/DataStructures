/*Merge Sort Array*/

#include <stdio.h>
#include <stdlib.h>

void merge_sort(int array[], int start, int end);
void merge(int array[], int start,int mid, int end);
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
	merge_sort(array,0, array_size-1);
	printf("Sorted array is: \n");
	print(array, array_size);
}
	
void merge_sort(int array[], int start, int end){
	if(end-start < 1){
		return;
	}else {
		int mid = start + (end -start +1)/2;
		merge_sort(array, start, mid -1);
		merge_sort(array, mid, end);
		merge(array, start, mid, end);
	}
}

void merge(int array[], int start, int mid, int end){
	int *temp = malloc(sizeof(int) * (end-start+1));
	int i = start;
	int j = mid;
	int k = 0;

	while(i<mid && j<=end){
		if(array[i] <= array[j]){
			temp[k] = array[i];
			i++;
		}
		else {
			temp[k] = array[j];
			j++;
		}
		k++;
	}
	
	while(i<mid){
		temp[k] = array[i];
		i++;
		k++;
	}
	while(j <= end){
		temp[k] = array[j];
		j++;
		k++;
	}
	
	for(k = 0;k <= (end-start);k++){
		array[start+k] = temp[k];	
	}
	free(temp);
}

void print(int array[], int array_size){
	int i = 0;
	for(i; i < array_size; i++){
		printf(" %d ",array[i]);
	}
	printf(" \n");
}
