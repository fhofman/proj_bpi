export interface Time {
  updated: string;
  updatedISO: Date;
  updateduk: string;
}

export interface USD {
  code: string;
  symbol: string;
  rate: string;
  description: string;
  rate_float: number;
}

export interface GBP {
  code: string;
  symbol: string;
  rate: string;
  description: string;
  rate_float: number;
}

export interface EUR {
  code: string;
  symbol: string;
  rate: string;
  description: string;
  rate_float: number;
}

export interface Bpi {
  USD: USD;
  GBP: GBP;
  EUR: EUR;
}

export interface Price {
  time: Time;
  disclaimer: string;
  chartName: string;
  bpi: Bpi;
}
