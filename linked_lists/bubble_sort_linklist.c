/* Bubble Sort Link List*/

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct node{
	size_t data;
	struct node* next;
};
void main(int argc, char* argv[]){

	if(argc < 2){
		printf("Enter size of list \n");
		exit(0);
	}

	struct node* headnode;
	int i = 0;
	int list_size = atoi(argv[1]);
	
	for(i; i < list_size;i++){
		addnode(&headnode,(size_t)(rand()%list_size));
	}
	printf("List before sorting \n");
	printlist(headnode);
	sortlist(&headnode);
	printf("List after sorting \n");
	printlist(headnode);

}

void sortlist(struct node** headref){
	struct node* current = *headref;
	current = *headref;
	int count= 0;
	if(current->next == NULL){
		return;
	}
	while(current != NULL){
		count++;
		current = current->next;
	}
	int i = 0;
	for(i ; i < count; i++){
		current = *headref;
		do{
			if(current->next->data < current->data){
				swapnode(headref,current);
				continue;
			}
			if(current->next != NULL){
				current = current->next;
			}
		}while(current->next != NULL);
		
	}
}		

void swapnode(struct node** headref, struct node* currentnode){
	struct node* current = *headref;
	struct node* firstnode;
	struct node* secondnode;
	if(*headref == currentnode){
		firstnode = current;
		secondnode = current->next;
		firstnode->next = secondnode->next;
		secondnode->next = firstnode;
		*headref = secondnode;
	}
	else{
	while(current->next != currentnode){
		current = current->next;
	}
	if(current->next->next != NULL){
		firstnode = current->next;
		secondnode = current->next->next;
	}
	firstnode->next = secondnode->next;
	secondnode->next = firstnode;
	current->next = secondnode;
	}
	
}

void addnode(struct node** headref,size_t data ){
	struct node* current = *headref;
	struct node* newnode = malloc(sizeof(struct node));
	newnode->data = data;
	newnode->next = NULL;

	if(current == NULL){
		*headref = newnode;
	}
	else{
		while(current->next != NULL){
			current = current->next;
		}
		current->next = newnode;
	}

}

void printlist(struct node* headnode){
	struct node* current = headnode;

	while(current != NULL){
		printf(" %d ",current->data);
		current = current->next;
	}
	printf(" \n");
}
