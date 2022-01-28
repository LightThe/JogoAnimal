import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
    selector: 'win-dialog',
    templateUrl: 'win-dialog.component.html',
    styleUrls: ['./win-dialog.component.scss']
})
export class WinDialogComponent {
    constructor(
        public dialogRef: MatDialogRef<WinDialogComponent>,
        @Inject(MAT_DIALOG_DATA) public data: string,
    ) {}

    onNoClick(): void {
        this.dialogRef.close();
    }
}