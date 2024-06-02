import { Injectable } from "@angular/core";
import { ToastrService } from "ngx-toastr";




@Injectable({
  providedIn: 'root'
})

export class AlertsService {
  constructor(private toastr: ToastrService) { }



  showInfo(message:string) {
    this.toastr.show(message, '',{
      toastClass:"absolute top-10 left-10 z-[4444] w-96 flex justify-between items-center p-4 mb-4 text-sm text-blue-800 rounded-lg bg-blue-50 dark:bg-gray-800 dark:text-blue-400",
      titleClass:'font-medium text-white ml-[100px]',
      positionClass:"toast-top-left",
      easing:"ease-in",
    });
  }
  showDanger(message:string) {
    this.toastr.show(message, '',{
      toastClass:"fixed top-10 left-10 z-[4444] w-96 flex items-center p-4 mb-4 text-sm text-red-800 rounded-lg bg-red-50 dark:bg-gray-800 dark:text-red-400",
      titleClass:'font-medium text-white ml-[100px]',
      positionClass:"toast-top-left",
      easing:"ease-in",
    });
  }
  showSuccess(message:string) {
    this.toastr.show(message, '',{
      toastClass:"fixed top-10 left-10 z-[4444] w-96 flex items-center p-4 mb-4 text-sm text-green-800 rounded-lg bg-green-50 dark:bg-gray-800 dark:text-green-400",
      titleClass:'font-medium text-white ml-[100px]',
      positionClass:"toast-top-left",
      easing:"ease-in",
    });
  }
  showWarning(message:string) {
    this.toastr.show(message, '',{
      toastClass:" fixed top-10 left-10 z-[4444] w-96 flex items-center p-4 mb-4 text-sm text-yellow-800 rounded-lg bg-yellow-50 dark:bg-gray-800 dark:text-yellow-300",
      titleClass:'font-medium text-white ml-[100px]',
      positionClass:"toast-top-left",
      easing:"ease-in",
    });
  }
  showDark(message:string) {
    this.toastr.show(message, '',{
      toastClass:" fixed top-10 left-10 z-[4444] w-96 flex items-center p-4 text-sm text-gray-800 rounded-lg bg-gray-50 dark:bg-gray-800 dark:text-gray-300",
      titleClass:'font-medium text-white ml-[100px]',
      positionClass:"toast-top-left",
      easing:"ease-in",
    });
  }
}
