#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void seq_search(int *array, int array_length,int num);
void print(int array[], int num);
void main(int argc, const char* argv[]){
	if(argc < 2){
		printf("You have to enter size of array \n");
		exit(0);
	}	

	int num = atoi(argv[1]);
	int array[num];
	int i = 0;
	int num_req;
	for(i = 0; i < num; i++){
		array[i] = rand() % num;
	}


	print(array, num);	
	printf("Enter element to be searched \n");
	scanf("%d",&num_req);

	seq_search(array,num, num_req);
		
}

void print(int array[], int num){
	int i = 0;
	for(i = 0; i < num; i++){
		printf(" %d ",array[i]);
	}
	printf(" \n ");
}

void seq_search(int* array, int array_length, int num){
	int i = 0;
	for(i = 0; i < array_length; i++){
		if(array[i] == num){
			break;
		}
	}

	if( i == array_length){
		printf("Element %d not found in Array \n", num);
	} else {
		printf("Element %d found at index %d in Array \n", num,i);
	}
}	

